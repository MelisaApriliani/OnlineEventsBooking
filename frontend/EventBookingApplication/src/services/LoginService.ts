import axios from 'axios';
import { LoginData, Token } from '../models/Login';

const LOGIN_URL = import.meta.env.VITE_API_LOGIN_URL;

export const LoginService = {

    async login(loginData: LoginData): Promise<string> {

    try{

        const response = await axios.post<Token>(`${LOGIN_URL}/login`, loginData);
        
        if (response.status === 200) {
            return response.data ? response.data.jwt: "";
            console.log('login response', response.data)
        } else {
            console.error('Login Failed: ', response.status);
        }
    }catch (error){
        console.log(error);
    }

    return "";
  },

 
};