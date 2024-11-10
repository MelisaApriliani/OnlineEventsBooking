import React, { useState, useEffect, useContext } from 'react';
import { EventDetails } from '../models/Event';
import { EventDate } from '../models/EventDate';
import { FaArrowDown, FaArrowUp } from 'react-icons/fa'; 
import { AuthContext } from '../context/AuthContext';

interface EventProps {
    events: EventDetails[];
    onUpdateEvent: () => void; // Define the prop for handling login success
}

const EventList: React.FC<EventProps> = ({ events, onUpdateEvent }) => {
    const { userDetails } = useContext(AuthContext)!; 
    const [loading, setLoading] = useState<boolean>(false);
    const [expandedEventId, setExpandedEventId] = useState<number | null>(null);

    

    useEffect(() => {
       console.log(events)
       setLoading(false)

        handleEventUpdate
 
    }, []);

    const handleToggleExpand = (eventId: number) => {
        if (expandedEventId === eventId) {
            setExpandedEventId(null); 
        } else {
            setExpandedEventId(eventId);
        }
    };

    const handleEventUpdate = async (e: React.FormEvent) => {
        e.preventDefault();
        onUpdateEvent()
        
        

    };

    if (loading) return <p>Loading...</p>;

    return (
        <div>
          {events.map((event: EventDetails) => {
            const isExpanded = expandedEventId === event.eventId;
    
            return (
              <div key={event.eventId} className="event-item" style={{ marginBottom: "10px", borderBottom: "1px solid #ddd" }}>
                <div className="event-header" style={{ display: "flex", alignItems: "center", justifyContent: "space-between" }}>
                  <div className="event-name" style={{ flex: 1 }}>
                    <h3 style={{ margin: 0 }}>{event.eventName}</h3>
                  </div>
    
                  <div
                    className="event-status"
                    style={{
                      backgroundColor:
                        event.status.id === 1 ? "green" : event.status.id === 2 ? "orange" : "red",
                      color: "white",
                      padding: "5px 10px",
                      borderRadius: "20px",
                      fontWeight: "bold",
                    }}
                  >
                    {event.status.statusName} 
                  </div>
    
                  <button
                    onClick={() => handleToggleExpand(event.eventId)}
                    style={{
                      background: "none",
                      border: "none",
                      cursor: "pointer",
                      fontSize: "20px",
                    }}
                  >
                    {isExpanded ? <FaArrowUp /> : <FaArrowDown />}
                  </button>
                </div>
    
                {isExpanded && (
                  <div className="event-details" style={{ padding: "10px 0", borderTop: "1px solid #ddd" }}>
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
    
                    {userDetails?.role === "ADMIN" && event.status.id === 2 && (
                      <div style={{ textAlign: "center", marginTop: "10px" }}>
                        <button style={{ padding: "8px 16px", backgroundColor: "blue", color: "white", border: "none", borderRadius: "5px" }}>
                          Update Event
                        </button>
                      </div>
                    )}
                  </div>
                )}
              </div>
            );
          })}
        </div>
      );
    };

export default EventList;