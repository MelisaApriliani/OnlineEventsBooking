import axios from 'axios';
import { EventDetails } from '../models/Event'
import { ApiResponse } from '../models/ApiReponse';

const API_URL = import.meta.env.VITE_API_BASE_URL;

export const EventService = {

  async getEventsByCompany(companyId: number): Promise<EventDetails[]> {
    const response = await axios.get<ApiResponse>(`${API_URL}/event/company/${companyId}`);
    return response.data.data;
  },

  async getEventsByVendor(vendorId: number): Promise<EventDetails[]> {
    const response = await axios.get<ApiResponse>(`${API_URL}/event/company/${vendorId}`);
    return response.data.data;
  },

  async createEvent(eventDetail: EventDetails): Promise<EventDetails> {
    const response = await axios.post<ApiResponse>(`${API_URL}/event/create`,eventDetail);
    return response.data.data;
  },

  async updateEvent(eventDetail: EventDetails): Promise<EventDetails> {
    const response = await axios.post<ApiResponse>(`${API_URL}/event/update`,eventDetail);
    return response.data.data;
  },
};