import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import EmployeeService from "../services/EmployeeService";
import Employee from "./Employee";
import "./Employee.css";

const EmployeeList = () => {
  const navigate = useNavigate();

  const [loading, setLoading] = useState(true);
  const [employees, setEmployees] = useState(null);

  useEffect(() => {
    const fetchData = async () => {
      setLoading(true);
      try {
        const response = await EmployeeService.getEmployees();
        setEmployees(response.data);
      } catch (error) {
        console.log(error);
      }
      setLoading(false);
    };
    fetchData();
  }, []);

  const deleteEmployee = (e, id) => {
    e.preventDefault();
    EmployeeService.deleteEmployee(id).then((res) => {
      if (employees) {
        setEmployees((prevElement) => {
          return prevElement.filter((employee) => employee.id !== id);
        });
      }
    });
  };

  return (
    <div className="container mx-auto my-8">
      {/* <div className="h-12">
        <button
          onClick={() => navigate("/addEmployee")}
          className="rounded bg-slate-600 text-white px-6 py-2 font-semibold"
        >
          Add Employee
        </button>
      </div> */}
      <div className="flex">
        {!loading && (
          <div className="employee">
            {employees?.map((employee) => (
              <Employee
                employee={employee}
                deleteEmployee={deleteEmployee}
                key={employee.id}
              ></Employee>
            ))}
            <div
              onClick={() => navigate("/addEmployee")}
              className="container2 addBtn"
            >
              +
            </div>
          </div>
        )}
      </div>
    </div>
  );
};

export default EmployeeList;
