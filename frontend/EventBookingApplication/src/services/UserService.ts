import axios from 'axios';
import { BusinessEntity } from '../models/User'
import { ApiResponse } from '../models/ApiReponse'

const API_URL = import.meta.env.VITE_API_BASE_URL;

export const UserService = {


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

  async getUserById(userId: string): Promise<BusinessEntity | null> {

    try{
      const response = await axios.get<ApiResponse>(`${API_URL}/user/details/${userId}`, {
        headers: this.getHeader(),
      });
      console.log('get user details response', response.data)
      if(response.status === 200){
        return response.data.data;
      }

    }catch (error) {
      console.log(error);
    }

    return null; 
  },

};