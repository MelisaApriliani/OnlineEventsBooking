import axios from 'axios';
import { BusinessEntity } from '../models/User'
import { ApiResponse } from '../models/ApiReponse'

const API_URL = import.meta.env.VITE_API_BASE_URL;

export const UserService = {

  async getUserById(userId: string): Promise<BusinessEntity> {
    const response = await axios.get<ApiResponse>(`${API_URL}/user/details/${userId}`);
    return response.data.data;
  },

 

};