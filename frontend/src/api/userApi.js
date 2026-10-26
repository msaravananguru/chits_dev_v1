// All APIs are POST with the input in the JSON body.
const API_BASE = `http://${window.location.hostname}:8080`

export async function login(username, password) {
  let response
  try {
    response = await fetch(`${API_BASE}/api/user/login`, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ username, password }),
    })
  } catch (e) {
    throw new Error("Can't reach the server. Check that the backend is running.")
  }

  const body = await response.json()
  if (!body.success) {
    throw new Error(body.message)
  }
  return body.data
}
