import axios from 'axios';
import { EventDetails, CreateEventPayload, UpdateEventPayload } from '../models/Event'
import { ApiResponse } from '../models/ApiReponse';

const API_URL = import.meta.env.VITE_API_BASE_URL;

export const EventService = {

  async getEventsByCompany(companyId: number): Promise<EventDetails[]> {
    try{
      const response = await axios.get<ApiResponse>(`${API_URL}/event/company/${companyId}`);
      console.log('get events by company response', response.data)
      if(response.status === 200){
        return response.data.data;
      }
    }catch (error){
      console.log(error);
    }

    return [];
  },

  async getEventsByVendor(vendorId: number): Promise<EventDetails[]> {
    try{
      const response = await axios.get<ApiResponse>(`${API_URL}/event/company/${vendorId}`);
      console.log('get events by vendor response', response.data)
      if(response.status === 200){
        return response.data.data;
      }
    }catch (error){
      console.log(error);
    }

    return [];
  },

  async createEvent(eventDetail: Partial<CreateEventPayload>): Promise<EventDetails | null> {
    try{
      const response = await axios.post<ApiResponse>(`${API_URL}/event/create`,eventDetail);
      console.log('create event response', response.data)
      if(response.status === 201){
        return response.data.data;
      }
    }catch (error){
      console.log(error);
    }

    return null;
  },

  async updateEvent(eventDetail: Partial<UpdateEventPayload>): Promise<EventDetails | null> {

    try{
      const response = await axios.post<ApiResponse>(`${API_URL}/event/update`,eventDetail);
      console.log('update event response', response.data)
      if(response.status === 201){
        return response.data.data;
      }
    }catch (error){
      console.log(error);
    }

    return null;
  },
};

