import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import EmployeeListComponent from './components/EmployeeListComponent'
import EmployeeComponent from './components/EmployeeComponent'
import HeaderComponent from './components/HeaderComponent'
import FooterComponent from './components/FooterComponent'
import { BrowserRouter, Route, Routes } from 'react-router-dom'

function App() {
  const [count, setCount] = useState(0)

  return (
    <> 
    <BrowserRouter>
    <HeaderComponent/>
    <Routes>
       <Route path='/' element = { <EmployeeListComponent/> }/>
       <Route path='/employees' element = { <EmployeeListComponent/> }/>
       <Route path='/add-employee' element = { <EmployeeComponent />}/>
       <Route path='/edit-employee/:id' element = { <EmployeeComponent /> }/>
    </Routes>
     <FooterComponent/>
    </BrowserRouter>
    </>
  )
}

export default App
