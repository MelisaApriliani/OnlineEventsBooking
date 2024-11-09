import axios from 'axios';
import { BusinessEntity } from '../models/User'
import { ApiResponse } from '../models/ApiReponse';

const API_URL = import.meta.env.VITE_API_BASE_URL;

export const VendorService = {

  async getVendors(): Promise<BusinessEntity[]> {
    const response = await axios.get<ApiResponse>(`${API_URL}/vendor`);
    return response.data.data;
  },


};