import React, {useContext} from 'react';
import LoginForm from '../components/LoginForm';
import { useNavigate } from 'react-router-dom';
import { UserService } from '../services/UserService';
import { BusinessEntity } from '../models/User';
import { AuthContext } from '../context/AuthContext';
import '../App.css';

// const handleSubmit = async () => {
 
// };

const LoginPage: React.FC = () => {
  const { saveUserDetails } = useContext(AuthContext)!; 
  const navigate = useNavigate();

  const handleLoginSuccess = async () => {
    console.log('User logged in successfully!');
    const userDetails:BusinessEntity|null = await UserService.getUserDetails();

    if(userDetails != null){
      saveUserDetails(userDetails);
    }
    navigate('/event/list');
  };

  return(
    <div className="login-container">

      <h1>Welcome to Event Online Booking Application!</h1>
      <LoginForm onLoginSuccess={handleLoginSuccess} />
    </div>
  );
};

export default LoginPage;