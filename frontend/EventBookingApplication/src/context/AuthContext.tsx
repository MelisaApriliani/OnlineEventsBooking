import React, { createContext, useState, useEffect, ReactNode } from 'react';
import { BusinessEntity } from '../models/User';


interface AuthContextType {
  token: string | null;
  userDetails: BusinessEntity | null;
  saveToken: (token: string) => void;
  saveUserDetails:(user: BusinessEntity)=> void;
  logout: () => void;
}

// Create Context with default values
export const AuthContext = createContext<AuthContextType | undefined>(undefined);

interface AuthProviderProps {
  children: ReactNode;
}

// Create a provider component
export const AuthProvider: React.FC<AuthProviderProps> = ({ children }) => {
  const [token, setToken] = useState<string | null>(null);
  const [userDetails, setUserDetails] = useState<BusinessEntity | null>(null);

  // Load token and user details from localStorage when the app loads
  useEffect(() => {
    const storedToken = localStorage.getItem('authToken');
    const storedUserDetails = localStorage.getItem('userDetails');
    
    if (storedToken) {
      setToken(storedToken);
    }

    if(storedUserDetails){
        setUserDetails(JSON.parse(storedUserDetails));
    }
  }, []);

  // Save token and user details to localStorage whenever they change
  useEffect(() => {
    if (token) {
      localStorage.setItem('authToken', token);
    }
    if (userDetails) {
      localStorage.setItem('userDetails', JSON.stringify(userDetails));
    }
  }, [token, userDetails]);

  const saveToken = (newToken: string) => {
    setToken(newToken);
  };

  const saveUserDetails = (newUser: BusinessEntity) => {
    setUserDetails(newUser);
  };

  const logout = () => {
    setToken(null);
    setUserDetails(null);
    localStorage.removeItem('authToken');
    localStorage.removeItem('userDetails');
  };

  return (
    <AuthContext.Provider value={{ token, userDetails, saveToken, saveUserDetails, logout }}>
      {children}
    </AuthContext.Provider>
  );
};