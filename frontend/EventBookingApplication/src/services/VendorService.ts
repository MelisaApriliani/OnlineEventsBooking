import axios from 'axios';
import { BusinessEntity } from '../models/User'
import { ApiResponse } from '../models/ApiReponse';

const API_URL = import.meta.env.VITE_API_BASE_URL;

export const VendorService = {

  async getVendors(): Promise<BusinessEntity[]> {
    try{
        const response = await axios.get<ApiResponse>(`${API_URL}/vendor`);
        console.log('get vendors response', response.data)
        if(response.status === 200){
          return response.data.data;
        }
        
    }catch (error){
        console.log(error);
    }

    return [];   
}

}


