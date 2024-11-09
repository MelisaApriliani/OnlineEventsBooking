import axios from 'axios';
import { Location } from '../models/Location'
import { ApiResponse } from '../models/ApiReponse';

const API_URL = import.meta.env.VITE_API_BASE_URL;

export const LocationService = {

  async getLocations(): Promise<Location[]> {
    const response = await axios.get<ApiResponse>(`${API_URL}/location`);
    return response.data.data;
  },

  async addLocation(location: Location): Promise<Location> {
    const response = await axios.post<ApiResponse>(`${API_URL}/location/create`,location);
    return response.data.data;
  },
};