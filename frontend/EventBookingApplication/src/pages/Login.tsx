import React from 'react';
import LoginForm from '../components/LoginForm';
import { useNavigate } from 'react-router-dom';
import '../App.css';

// const handleSubmit = async () => {
 
// };

const LoginPage: React.FC = () => {

  const navigate = useNavigate();

  const handleLoginSuccess = () => {
    console.log('User logged in successfully!');
    navigate('/event/book');
  };

  return(
    <div className="login-container">

      <h1>Welcome to Event Online Booking Application!</h1>
      <LoginForm onLoginSuccess={handleLoginSuccess} />
    </div>
  );
};

export default LoginPage;