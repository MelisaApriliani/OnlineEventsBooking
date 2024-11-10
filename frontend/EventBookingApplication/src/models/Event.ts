import { EventDate } from "./EventDate";
import { Location } from './Location'
import { BusinessEntity } from "./User";

export interface CreateEventPayload {
    companyId: number;
    vendorId: number;
    eventName: string;
    description: string;
    location: Location;
    dateCreate: Date;
    eventDate: EventDate[];
}

export interface UpdateEventPayload {
    eventId: number;
    companyId: number;
    vendorId: number;    
    dateCreate: Date;
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
    dateCreate: Date;
    status: EventStatus;
    remarks: string;
    eventDates: EventDate[];
}

export interface EventStatus{
    id: number;
    statusName: string;
}

