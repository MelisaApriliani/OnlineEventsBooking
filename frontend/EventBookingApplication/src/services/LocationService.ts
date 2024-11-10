import axios from 'axios';
import { Location } from '../models/Location'
import { ApiResponse } from '../models/ApiReponse';

const API_URL = import.meta.env.VITE_API_BASE_URL;

export const LocationService = {

  getAuthToken(): string | null{
    return localStorage.getItem('authToken');
  },

  getHeader(): any{
    const token = this.getAuthToken();
    if(token){
      return {
        Authorization: `Bearer ${token}`,
        'Content-Type': 'application/json',
      };

    }else{
      return {
        'Content-Type': 'application/json',
      };
    }
  },

  async getLocations(): Promise<Location[]> {

      try{
          const response = await axios.get<ApiResponse>(`${API_URL}/location`, {
            headers: this.getHeader(),
          });
          console.log('get locations response', response.data)
          if(response.status === 200){
            return response.data.data;
          }
          
      }catch (error){
          console.log(error);
      }
      return [];


  },

  async addLocation(location: Location): Promise<Location | null> {

    try{
      const response = await axios.post<ApiResponse>(`${API_URL}/location/create`, location , {
        headers: this.getHeader(),
      });
      console.log('add location response', response)
      if(response.status === 201){
        return response.data.data;
      }
    }catch (error){
      console.log(error);
    }

    return null;
  },
};