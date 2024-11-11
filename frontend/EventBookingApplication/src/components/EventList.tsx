import React, { useState, useEffect, useContext } from 'react';
import { EventDetails } from '../models/Event';
import { EventDate } from '../models/EventDate';
// import { FaArrowDown, FaArrowUp } from 'react-icons/fa'; 
import { AuthContext } from '../context/AuthContext';
import '../styles/eventList.css';

interface EventProps {
    events: EventDetails[];
    onUpdateEvent: (eventDetails:EventDetails, statusId: number, selectedDate:EventDate | null, remarks:string) => void; // Define the prop for handling login success
}

const EventList: React.FC<EventProps> = ({ events, onUpdateEvent }) => {
    const { userDetails } = useContext(AuthContext)!; 
    const [showModal, setShowModal] = useState(false);
    const [showApproveModal, setShowApproveModal] = useState(false);
    const [remarks, setRemarks] = useState('');
    const [selectedEvent, setSelectedEvent] = useState<EventDetails | null>(null);
    const [selectedDate, setSelectedDate] = useState<EventDate | null>(null);
    const [loading, setLoading] = useState<boolean>(false);

    const handleUpdateClick = (event: EventDetails) => {
        setSelectedEvent(event);
        setShowModal(true);
    };

    const handleApprove = () => {
        setShowApproveModal(true);
        setShowModal(false);
    };

    const handleReject = () => {
        if (selectedEvent) {
            onUpdateEvent(selectedEvent, 3, null, remarks);
            closeModals();
        }
    };

    const confirmApproval = () => {
        if (selectedEvent && selectedDate) {
            onUpdateEvent(selectedEvent, 1, selectedDate, remarks);
            closeModals();
        }
    };

    const closeModals = () => {
        setShowModal(false);
        setShowApproveModal(false);
        setRemarks('');
        setSelectedEvent(null);
        setSelectedDate(null);
    };

    

    useEffect(() => {
       console.log(events)
       setLoading(false)
 
    }, []);

   

    if (loading) return <p>Loading...</p>;

    return (
        <div>
            {events.map((event: EventDetails) => {
                return (
                <div key={event.eventId} className="event-item">
                    <div className="event-header">
                        <div className="event-name">
                            <h3>{event.eventName}</h3>
                        </div>

                        <div
                            className={`event-status ${
                            event.eventStatus.id === 1
                                ? "status-green"
                                : event.eventStatus.id === 2
                                ? "status-orange"
                                : "status-red"
                            }`}
                        >
                            {event.eventStatus.statusName}
                        </div>
                    </div>

                    <div className="event-details">
                        <div>
                        <strong>Description:</strong> {event.description}
                        </div>
                        <div>
                        <strong>Location:</strong> {event.location.name},{event.location.address}
                        </div>
                        <div>
                        <strong>Vendor:</strong> {event.vendor.businessEntityName}
                        </div>
                        <div>
                        <strong>Event Dates:</strong>
                        <ul>
                            {event.eventDates.map((eventDate: EventDate) => (
                            <li key={eventDate.id}>{new Date(eventDate.date).toLocaleDateString()}</li>
                            ))}
                        </ul>
                        </div>

                        {userDetails?.role === "ADMIN" && event.eventStatus.id === 2 && (
                        <div className="update-event">
                            <button onClick={() => handleUpdateClick(event)} className="update-button">Update Event</button>
                        </div>
                        )}
                    </div>
                </div>
                );
            })}

            {showModal && (
                <div className="modal">
                    <h2>Update Event</h2>
                    <p>Would you like to approve or reject this event?</p>
                    <input
                        type="text"
                        placeholder="Enter remarks"
                        value={remarks}
                        onChange={(e) => setRemarks(e.target.value)}
                    />
                    
                    <div className="button-container">
                        <button onClick={handleReject} className="reject-button">
                            Reject
                        </button>
                        <button onClick={handleApprove} className="approve-button">
                            Approve
                        </button>
                    </div>
                    
                </div>
            )}

            {showApproveModal && (
                <div className="modal">
                    <h2>Please select one event date</h2>
                    <select
                        value={selectedDate?.date}
                        onChange={(e) => {
                            const selectedDate = selectedEvent?.eventDates.find(
                                (date) => date.date === e.target.value
                            ) || null;  
                            setSelectedDate(selectedDate); 
                        }}
                    >
                        <option value="">Select a date</option>
                        {selectedEvent?.eventDates.map((date) => (
                            <option key={date.id} value={date.date}>
                                {new Date(date.date).toLocaleDateString()}
                            </option>
                        ))}
                    </select>
                    <div className="button-container">
                        <button onClick={confirmApproval} className="confirm-button">Confirm</button>
                    </div>
                </div>
            )}  
        </div>
      );
    };

export default EventList;