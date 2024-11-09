import { EventDate } from "./EventDate";

export interface CreateEventPayload {
    eventId: number;
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
    eventName: string;
    description: string;
    location: Location;
    dateCreate: Date;
    statusId: number;
    remarks: string;
    eventDates: EventDate[];
}

export interface EventDetails {
    eventId: number;
    companyId: number;
    vendorId: number;
    eventName: string;
    description: string;
    location: Location;
    dateCreate: Date;
    statusId: number;
    remarks: string;
    eventDates: EventDate[];
}