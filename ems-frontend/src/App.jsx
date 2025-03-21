import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import EmployeeListComponent from './components/EmployeeListComponent'
import EmployeeComponent from './components/EmployeeComponent'
import HeaderComponent from './components/HeaderComponent'
import FooterComponent from './components/FooterComponent'
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import DepartmentListComponent from './components/DepartmentListComponent'
import DepartmentComponent from './components/DepartmentComponent'

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
       <Route path='/departments' element = { <DepartmentListComponent/>}></Route>
       <Route path='/add-department' element = { <DepartmentComponent/> }/>
       <Route path='/edit-department/:id' element = { <DepartmentComponent />}/>
    </Routes>
     <FooterComponent/>
    </BrowserRouter>
    </>
  )
}

export default App
