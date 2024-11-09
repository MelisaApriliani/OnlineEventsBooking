import axios from 'axios';
import { LoginData, Token } from '../models/Login';

const LOGIN_URL = import.meta.env.VITE_API_LOGIN_URL;

export const LoginService = {


  async login(loginData: LoginData): Promise<String> {
    const response = await axios.post<Token>(`${LOGIN_URL}/login`, loginData);
    return response.data.token;
  },

 
};