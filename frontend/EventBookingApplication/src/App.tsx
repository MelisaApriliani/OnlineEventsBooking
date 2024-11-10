import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import LoginPage from './pages/Login';
import EventBooking from './pages/EventBooking';
import { AuthProvider } from './context/AuthContext';

const App: React.FC = () => (
  <AuthProvider>
    <div id="main">
        <Router>
          <Routes>
            <Route path="/" element={<LoginPage />} />
            <Route path="/event/book" element={<EventBooking/>} />
          </Routes>
        </Router>

    </div>
  </AuthProvider>

  
);

export default App;