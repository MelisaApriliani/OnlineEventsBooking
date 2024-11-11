import React, { useState, useContext, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import { AuthContext } from '../context/AuthContext';
import { CreateEventPayload, EventDetails } from '../models/Event';
import { Location } from '../models/Location';
import { BusinessEntity } from '../models/User';
import { EventDate } from '../models/EventDate';
import { EventService } from '../services/EventService';
import { LocationService } from '../services/LocationService';
import { VendorService } from '../services/VendorService';
import Select, { SingleValue } from 'react-select';
import DatePicker from 'react-datepicker';
import '../App.css';



const EventBooking: React.FC = () => {
    const { userDetails } = useContext(AuthContext)!;
    const [eventForm, setEventForm] = useState<CreateEventPayload | null>(null);
    const [locations, setLocations] = useState<Location[]>([]);
    const [vendors, setVendors] = useState<BusinessEntity[]>([]);
    const [newLocation, setNewLocation] = useState<Location | null>({
        id:0,
        name: '',
        postalCode: '',
        address: ''
    });
    const [isNewLocation, setIsNewLocation] = useState<boolean>(false);
    const [loading, setLoading] = useState<boolean>(true);
    const navigate = useNavigate();

    // if (!userDetails) {
    //   return <p>User is not logged in.</p>;
    // }

    useEffect(() => {

        initializeEventForm();
        const fetchData = async () => {
            setLoading(true);
            const locationList:Location[] = await LocationService.getLocations();

            if(locationList && locationList.length>0){
                setLocations(locationList)
            }

            const vendorList = await VendorService.getVendors(); 
            if(vendorList && vendorList.length>0){
                setVendors(vendorList);
            }
            setLoading(false)
            
        };

        console.log(userDetails)
      
        fetchData(); 
     
    }, []);

    const initializeEventForm = () => {
        const companyId = userDetails?.businessId ? userDetails?.businessId : 0 ; 
        const today = new Date();
        const dateCreated = today.toISOString().split('T')[0];
        
        const minDate = new Date(today);
        minDate.setDate(today.getDate() + 6); // 6 days ahead of today
        const dates: EventDate[] = [];

        for (let i = 0; i < 3; i++) {
            
            const eventDate = new Date(minDate);
            eventDate.setDate(minDate.getDate() + i);
            const dateStr = eventDate.toISOString().split('T')[0]

            const event: EventDate = {
                id: 0, 
                date: dateStr, 
            };

            dates.push(event);
        }
        
        const initialEventForm: CreateEventPayload = {
          companyId,
          vendorId: 0, 
          eventName: '',
          description: '',
          location: {
            id: 0,
            name: '',
            postalCode: '',
            address: '',
          },
          dateCreated,
          eventDates: dates, 
        };
    
        setEventForm(initialEventForm); 
      };

    useEffect(() => {

        console.log(eventForm)

    }, [eventForm])


    // const handleLogout = () => {
    //     console.log('User logged in successfully!');
    //     logout();
    //     navigate("/", { replace: true });
    // };

    const handleEventBooking = async (e: React.FormEvent) => {
        e.preventDefault();
        if(eventForm != null){
            try {

                if(isNewLocation && newLocation){
                    const updatedEventForm = {
                        ...eventForm,
                        location: newLocation, 
                    };
        
                    if (!updatedEventForm.location) {
                        console.error("Location is missing.");
                        return;
                    }
                }

                setLoading(true);
                const details:EventDetails|null = await EventService.createEvent(eventForm);
                console.log(details?.eventId);
                setLoading(false);

                navigate("/event/list", { replace: true });
            } catch (error) {
                console.error('Error logging in user:', error);
        
            } finally {
                setLoading(false);
            }
        }
    };

    const handleFieldChange = (
        e: React.ChangeEvent<HTMLInputElement | HTMLSelectElement | HTMLTextAreaElement>
      ) => {
        const { name, value } = e.target;
    
        setEventForm((prevForm) => {
          if (prevForm) {
            return {
              ...prevForm,
              [name as keyof CreateEventPayload]: value, 
            };
          }
    
          return prevForm; 
        });

    };

    const handleSelectChange = (
        selectedOption: SingleValue<{ value: Location| number; label: string }>, 
        name: keyof CreateEventPayload 
      ) => {
        if (selectedOption) {
          const { value } = selectedOption;
          setNewLocation(null);
          setIsNewLocation(false);
      
          setEventForm((prevForm) => {
            if (prevForm) {
              return {
                ...prevForm,
                [name]: value, 
              };
            }
            return prevForm; 
          });
        }
    };

    const handleDateChange = (date: Date | null, index: number) => {
        if (date) {
            const formattedDate = date.toISOString().split('T')[0];
            setEventForm((prevForm) => {
                if (prevForm) {
                    const updatedEventDates = [...prevForm.eventDates];
                    updatedEventDates[index] = { ...updatedEventDates[index], date: formattedDate };
                    return {
                        ...prevForm,
                        eventDates: updatedEventDates
                    };
                }
                return prevForm;
            });
        }
    };

    const handleNewLocationinputChange = (
        e: React.ChangeEvent<HTMLInputElement>
      ) => {
        const { name, value } = e.target;
    
        setEventForm((prevForm) => {
            if (prevForm) {
              return {
                ...prevForm,
                location: {
                  ...prevForm.location,
                  [name]: value, 
                },
              };
            }
        
            return prevForm;
        });

    };
    

    

    if (loading) return <p>Loading...</p>;
    const today = new Date();
    const minDate = new Date(today);
    minDate.setDate(today.getDate() + 6); 

    const maxDate = new Date(today);
    maxDate.setMonth(today.getMonth() + 6);

    return (
        <div className="event-booking-container">
            <h1>Book your event!</h1>
            <div className="event-form">

                <div className="form-group">
                        <label>Event Name</label>
                        <input name="eventName" type="text" placeholder="Enter event name" value={eventForm?.eventName} onChange={(e) => handleFieldChange(e)} />
                        {/* {errors[FIELD_NAMES.FIRST_NAME] && <div className="error">{errors[FIELD_NAMES.FIRST_NAME]}</div>} */}
                </div>
                <div className="form-group">
                        <label>Event Description</label>
                        <input name="description" type="text" placeholder="Enter event description" value={eventForm?.description} onChange={(e) => handleFieldChange(e)} />
                </div>

                <div className="form-group">
                    <label>Location</label>
                    <Select
                        name = "locationId"
                        options={locations.map((location: Location) => ({ value: location, label: location.name }))}
                        onChange={(selectedOption) => handleSelectChange(selectedOption, "location")} 
                        placeholder="Select location"
                    />
                    <button onClick={() => setIsNewLocation(true)}>Add new location</button>
                </div>

                {isNewLocation && 
                (
                    <div>
                        <div className="form-group">  
                            <label>Location Name</label>
                            <input name="name" type="text" placeholder="Enter location name" value={newLocation?.name} onChange={(e) => handleNewLocationinputChange(e)} />
                        </div>
                        <div className="form-group">  
                            <label>Address</label>
                            <input name="address" type="text" placeholder="Enter address" value={newLocation?.address} onChange={(e) => handleNewLocationinputChange(e)} />
                        </div>
                        <div className="form-group">  
                            <label>Postal Code</label>
                            <input name="postalCode" type="text" placeholder="Enter postalCode" value={newLocation?.postalCode} onChange={(e) => handleNewLocationinputChange(e)} />
                        </div>
                    </div>
                    
                )}

                <div className="form-group">
                    <label>Vendor</label>
                    <Select
                        name = "vendorId"
                        options={vendors.map((vendor: BusinessEntity) => ({ value: vendor.businessId, label: vendor.businessEntityName }))}
                        onChange={(selectedOption) => handleSelectChange(selectedOption, "vendorId")} 
                        placeholder="Select vendor"
                    />
                    {/* {errors[FIELD_NAMES.HEALTHCARE_FACILITY_ID] && <div className="error">{errors[FIELD_NAMES.HEALTHCARE_FACILITY_ID]}</div>} */}
                </div>
                <div>
                    
                    <label>Proposed Dates</label>
                    {eventForm?.eventDates.map((eventDate, index) => (
                        <div key={index} className="form-group">
                            <DatePicker
                                selected={new Date(eventDate.date)}
                                onChange={(date) => handleDateChange(date, index)}
                                minDate={minDate}
                                dateFormat="yyyy-MM-dd"
                            />
                        </div>
                    ))}
                </div>
            </div>




            <button onClick={handleEventBooking}>Book Event</button>
        </div>

    );
};
  
export default EventBooking;