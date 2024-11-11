import React, {useState, useContext, useEffect} from 'react';
import { useNavigate } from 'react-router-dom';
import { EventDetails, UpdateEventPayload } from '../models/Event';
import { EventDate } from '../models/EventDate';
import { AuthContext } from '../context/AuthContext';
import { EventService } from '../services/EventService';
import '../App.css';
import  EventList  from '../components/EventList';


const EventsDashboard: React.FC = () => {
    const { userDetails } = useContext(AuthContext)!; 
    const [events, setEvents] = useState<EventDetails[]>([]);
    // const [loading, setLoading] = useState<boolean>(true);
    const navigate = useNavigate();

    useEffect(() => {
        console.log(userDetails)
        fetchData(); 

    }, [ userDetails])

    const fetchData = async () => {
        console.log("fetching events");
        if (userDetails != null) {
            let eventDetails: EventDetails[] = [];
            if (userDetails?.role === "ADMIN") {
                console.log("fetch for role admin");
                eventDetails = await EventService.getEventsByVendor(userDetails.businessId);
            } else if (userDetails?.role === "USER") {
                console.log("fetch for role user");
                eventDetails = await EventService.getEventsByCompany(userDetails.businessId);
            }

            if (eventDetails && eventDetails.length > 0) {
                setEvents(eventDetails);
            }
        }
    };

    const handleUpdateEvent = async (event: EventDetails,status: number, selectedDate?: EventDate|null, remarks?: string
    ) => {
        try {
            
            let dates: EventDate[] =[]
            if(selectedDate){
                dates = [selectedDate]
            }else{
                dates = event.eventDates;
            }
            const updatePayload : UpdateEventPayload = {
                eventId:event.eventId,
                eventName:event.eventName,
                companyId: event.companyId,
                vendorId: event.vendor.businessId,
                dateCreated: event.dateCreated,
                statusId: status,
                remarks: remarks? remarks : "",
                eventDates: dates
            }
            console.log('Event updated parload:', updatePayload);
            const updateEventDetails = await EventService.updateEvent(updatePayload);
            if(updateEventDetails != null){
                console.log('Successfully update event');

                //TODO, find other way to refresh event list
                fetchData();
                
            }
            

        } catch (error) {
           
            console.error(error);
            alert('An error occurred while updating the event.');
        }
    };

    const handleCreateEvent = async () => {
        navigate('/event/book');
    };

    return(
        
        <div className="login-container">
        <h1>Welcome to Event Online Booking Application!</h1>
        <h2>You are logged in as <strong>{userDetails?.businessEntityName}</strong></h2>
        
        <div className="role-and-button">
            <p><strong>Role: </strong>{userDetails?.role}</p>
            <button onClick={handleCreateEvent} className="create-event-button">Create Event</button>
        </div>
        
        <EventList events={events} onUpdateEvent={handleUpdateEvent} />
    </div>
    );
};

export default EventsDashboard;