import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import 'react-datepicker/dist/react-datepicker.css';
import LoginPage from './pages/Login';
import EventBooking from './pages/EventBooking';
import { AuthProvider } from './context/AuthContext';
import EventsDashboard from './pages/EventsDashboard';

const App: React.FC = () => (
  <AuthProvider>
    <div id="main">
        <Router>
          <Routes>
            <Route path="/" element={<LoginPage />} />
            <Route path="/event/book" element={<EventBooking/>} />
            <Route path="/event/list" element={<EventsDashboard/>} />
          </Routes>
        </Router>

    </div>
  </AuthProvider>

  
);

export default App;