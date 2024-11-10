import React, { useState, useContext, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import { AuthContext } from '../context/AuthContext';
import { EventDetails } from '../models/Event';
import { Location } from '../models/Location';
import { BusinessEntity } from '../models/User';
import { EventService } from '../services/EventService';
import { LocationService } from '../services/LocationService';
import { VendorService } from '../services/VendorService';
// import DatePicker from 'react-datepicker';
import Select, { SingleValue } from 'react-select';
import DatePicker from 'react-datepicker';
import '../App.css';



const EventBooking: React.FC = () => {
    const { userDetails } = useContext(AuthContext)!;
    const [eventForm, setEventForm] = useState<EventDetails | null>(null);
    const [locations, setLocations] = useState<Location[]>([]);
    const [vendors, setVendors] = useState<BusinessEntity[]>([]);
    // const [newLocation, setNewLocation] = useState<Location>();
    const [isNewLocation, setIsNewLocation] = useState<boolean>(false);
    const [loading, setLoading] = useState<boolean>(true);
    const navigate = useNavigate();

    // if (!userDetails) {
    //   return <p>User is not logged in.</p>;
    // }

    useEffect(() => {
       
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


    // const handleLogout = () => {
    //     console.log('User logged in successfully!');
    //     logout();
    //     navigate("/", { replace: true });
    // };

    const handleEventBooking = async (e: React.FormEvent) => {
        e.preventDefault();
        if(eventForm != null){
            try {
                setLoading(true);
                const details:EventDetails|null = await EventService.createEvent(eventForm);
                console.log(details?.eventId);

                navigate("/", { replace: true });
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
              [name as keyof EventDetails]: value, 
            };
          }
    
          return prevForm; 
        });
    };

    const handleSelectChange = (
        selectedOption: SingleValue<{ value: number; label: string }>, 
        name: keyof EventDetails 
      ) => {
        if (selectedOption) {
          const { value } = selectedOption;
      
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

    const handleDateChange = (date: Date | null) => {
        if (date) {
          // Convert date to YYYY-MM-DD format
          const formattedDate = date.toISOString().split('T')[0];
          console.log(formattedDate)
        //   onChange(FIELD_NAMES.DATE, formattedDate);
        }
    };

    

    if (loading) return <p>Loading...</p>;
    const today = new Date();
    const minDate = new Date(today);
    minDate.setDate(today.getDate() + 6); // Minimum date is 6 days from now

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
                        {/* {errors[FIELD_NAMES.FIRST_NAME] && <div className="error">{errors[FIELD_NAMES.FIRST_NAME]}</div>} */}
                </div>

                <div className="form-group">
                    <label>Location</label>
                    <Select
                        name = "locationId"
                        options={locations.map((location: Location) => ({ value: location.id, label: location.name }))}
                        onChange={(selectedOption) => handleSelectChange(selectedOption, "location")} 
                        placeholder="Select location"
                    />
                    <button onClick={() => setIsNewLocation(true)}>Add new location</button>
                    {/* {errors[FIELD_NAMES.HEALTHCARE_FACILITY_ID] && <div className="error">{errors[FIELD_NAMES.HEALTHCARE_FACILITY_ID]}</div>} */}
                </div>

                {isNewLocation && 
                (
                    <div className="form-group">
                    </div>
                    
                )}

                <div className="form-group">
                    <label>Vendor</label>
                    <Select
                        name = "vendorId"
                        options={vendors.map((vendor: BusinessEntity) => ({ value: vendor.businessId, label: vendor.businessEntityName }))}
                        onChange={(selectedOption) => handleSelectChange(selectedOption, "vendor")} 
                        placeholder="Select vendor"
                    />
                    {/* {errors[FIELD_NAMES.HEALTHCARE_FACILITY_ID] && <div className="error">{errors[FIELD_NAMES.HEALTHCARE_FACILITY_ID]}</div>} */}
                </div>
                <div className="form-group">
                    <label>Date</label>
                    <DatePicker
                        selected={eventForm?.eventDates[0] ? eventForm.eventDates[0].date: minDate}
                        onChange={handleDateChange}
                        minDate={minDate} 
                        maxDate={maxDate} 
                        dateFormat="yyyy-MM-dd" 
                    />
                    {/* {errors[FIELD_NAMES.DATE] && <div className="error">{errors[FIELD_NAMES.DATE]}</div>} */}
                </div>
            </div>




            <button onClick={handleEventBooking}>Book Event</button>
        </div>

    );
};
  
export default EventBooking;