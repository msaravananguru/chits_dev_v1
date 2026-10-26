import { Navigate, useNavigate } from 'react-router-dom'

// First page after login: two options (Chits, Finance) with Profile and Logout at the top right.
export default function Welcome() {
  const navigate = useNavigate()
  const stored = localStorage.getItem('chitsUser')

  if (!stored) {
    return <Navigate to="/login" replace />
  }
  const user = JSON.parse(stored)

  function handleLogout() {
    localStorage.removeItem('chitsUser')
    navigate('/login')
  }

  return (
    <div className="welcome-page">
      <header className="topbar">
        <div className="brand">Sudar</div>
        <div className="topbar-actions">
          <button className="ghost" type="button">
            {user.fullName}
          </button>
          <button className="ghost" type="button" onClick={handleLogout}>
            Logout
          </button>
        </div>
      </header>

      <main className="options">
        <div className="option-card">
          <div className="option-icon">👥</div>
          <div className="option-title">Chits</div>
        </div>
        <div className="option-card">
          <div className="option-icon">₹</div>
          <div className="option-title">Finance</div>
        </div>
      </main>
    </div>
  )
}
