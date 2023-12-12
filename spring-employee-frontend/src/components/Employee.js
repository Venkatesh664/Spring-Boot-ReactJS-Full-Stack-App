import React from "react";
import { useNavigate } from "react-router-dom";
import "./Employee.css";

const Employee = ({ employee, deleteEmployee }) => {
  const navigate = useNavigate();
  const editEmployee = (e, id) => {
    e.preventDefault();
    navigate(`/editEmployee/${id}`);
  };

  return (
    <div className="container2 shadow" key={employee.id} onClick={(e, id) => editEmployee(e, employee.id)}>
      <div className="field">
        <div className="title">Firstname</div>
        <div className="data">{employee.firstname}</div>
      </div>
      <div className="field">
        <div className="title">Lastname</div>
        <div className="data">{employee.lastname}</div>
      </div>
      <div className="field">
        <div className="title">Email</div>
        <div className="data">{employee.emailId}</div>
      </div>
      <div className="field2">
        <a
          onClick={(e, id) => editEmployee(e, employee.id)}
          className="editBtn"
        >
          Edit
        </a>
        <a
          onClick={(e, id) => deleteEmployee(e, employee.id)}
          className="deleteBtn"
        >
          Delete
        </a>
      </div>
    </div>
    // <tr key={employee.id}>
    //   <td className="text-left px-6 py-4 whitespace-nowrap">
    //     <div className="text-sm text-gray-500">{employee.firstname}</div>
    //   </td>
    //   <td className="text-left px-6 py-4 whitespace-nowrap">
    //     <div className="text-sm text-gray-500">{employee.lastname}</div>
    //   </td>
    //   <td className="text-left px-6 py-4 whitespace-nowrap">
    //     <div className="text-sm text-gray-500">{employee.emailId}</div>
    //   </td>
    //   <td className="text-right px-6 py-4 whitespace-nowrap font-medium text-sm">
    //     <a
    //       onClick={(e, id) => editEmployee(e, employee.id)}
    //       className="text-indigo-600 hover:text-indigo-800 px-4 hover:cursor-pointer">
    //       Edit
    //     </a>
    //     <a
    //       onClick={(e, id) => deleteEmployee(e, employee.id)}
    //       className="text-indigo-600 hover:text-indigo-800 hover:cursor-pointer">
    //       Delete
    //     </a>
    //   </td>
    // </tr>
  );
};

export default Employee;
