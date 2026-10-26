import { Navigate, Route, Routes } from 'react-router-dom'
import DummyLogin from './dummy/DummyLogin.jsx'
import Welcome from './welcome/Welcome.jsx'

export default function App() {
  return (
    <Routes>
      <Route path="/" element={<Navigate to="/login" replace />} />
      <Route path="/login" element={<DummyLogin />} />
      <Route path="/welcome" element={<Welcome />} />
      <Route path="*" element={<Navigate to="/login" replace />} />
    </Routes>
  )
}
