import React, { useEffect, useState } from 'react'
import { listEmployees,deleteEmployee } from '../services/EmployeeService'
import { useNavigate } from 'react-router-dom'

const EmployeeListComponent = () => {

    const [employees, setEmployees] = useState([])
    const navigator = useNavigate();

    useEffect(()=> {
        listEmployees().then((response)=> {
          getEmployeesList();
        }).catch(error =>{
             console.log(error);
        })
    })


    function addNewEmployee(){
      navigator('/add-employee')
  }

  function getEmployeesList() {
    listEmployees().then((response) => {
        setEmployees(response.data);
    }).catch(error => {
        console.error(error);
    })
}

function updateEmployee(id) {
  navigator(`/edit-employee/${id}`)
}

function removeEmployee(id){
  console.log(id);

  deleteEmployee(id).then((response) =>{
      getAllEmployees();
  }).catch(error => {
      console.error(error);
  })
}

// const dummydata = [
//     { 
//         "id": 1,
//         "firstName": "Wialliam",
//         "lastName": "Smith",
//         "email":"wialliamsmith@xmail.com"
//     },
//     { 
//         "id": 2,
//         "firstName": "Anthanio",
//         "lastName": "joseph",
//         "email":"Anthanio112@xmail.com"
//     },
//     { 
//         "id": 3,
//         "firstName": "Bisher",
//         "lastName": "Adab",
//         "email":"Bisheradab@xmail.com"
//     },
//     { 
//         "id": 4,
//         "firstName": "Micheal",
//         "lastName": "Wizlak",
//         "email":"Micheal_334@xmail.com"
//     },
//     { 
//         "id": 5,
//         "firstName": "Charlies",
//         "lastName": "Rizwak",
//         "email":"charlies7778@xmail.com"
//     }

// ]

  return (
    <div className='mt-10 container'>
         <div className='card'>
         <div className='card-header text-center'>
            <label className="fw-bold" > List of Employees</label>
            </div>
            <div className='card-body'>
            <table className='table table-striped table-bordered table-hover'>
            <thead>
                <tr>
                    <th scope='col'>
                    <label>#</label>
                    </th>
                    <th scope='col'>
                       <label>First Name</label>
                    </th>
                    <th scope='col'>
                      <label>Last Name</label>
                    </th>
                    <th scope='col'>
                    <label>Email</label>
                    </th>
                </tr>
            </thead>
            <tbody>
                {employees.map(employee=>(
                 <tr key={employee.id} scope='row'>
                     <td>{employee.id}</td>
                     <td>{employee.firstName}</td>
                     <td>{employee.lastName}</td>
                     <td>{employee.email}</td>
                     <td>
                        <button className='btn btn-info' onClick={() => updateEmployee(employee.id)}>Update</button>
                        <button className='btn btn-danger' onClick={() => removeEmployee(employee.id)}style={{marginLeft: '10px'}}>Delete</button>
                     </td>
                  </tr>
                ))}
              
            </tbody>
        </table>
        <button className='btn btn-primary mb-2' onClick={ addNewEmployee }>Add Employee</button>
                </div>
         </div>
    </div>
  )
}

export default EmployeeListComponent