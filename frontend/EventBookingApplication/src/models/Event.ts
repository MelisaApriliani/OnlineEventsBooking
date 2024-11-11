import { EventDate } from "./EventDate";
import { Location } from './Location'
import { BusinessEntity } from "./User";

export interface CreateEventPayload {
    companyId: number;
    vendorId: number;
    eventName: string;
    description: string;
    location: Location;
    dateCreated: string;
    eventDates: EventDate[];
}

export interface UpdateEventPayload {
    eventId: number;
    eventName: string;
    companyId: number;
    vendorId: number;    
    dateCreated: Date;
    statusId: number;
    remarks: string;
    eventDates: EventDate[];
}

export interface EventDetails {
    eventId: number ;
    companyId: number;
    vendor: BusinessEntity;
    eventName: string;
    description: string;
    location: Location;
    dateCreated: Date;
    eventStatus: EventStatus;
    remarks: string;
    eventDates: EventDate[];
}

export interface EventStatus{
    id: number;
    statusName: string;
}

