import axios from 'axios';

const EMPLOYEE_API_BASE_URL = 'http://localhost:8081/api/employees';

export const listEmployees = () => {
    return axios.get(EMPLOYEE_API_BASE_URL);
};

export const createEmployee = (employee) => axios.post(EMPLOYEE_API_BASE_URL, employee);

export const getEmployee =(employeeeId) => axios.get(EMPLOYEE_API_BASE_URL + '/' + employeeeId);

export const updateEmployee =(employeeeId, employee) => axios.put(EMPLOYEE_API_BASE_URL + '/' + employeeeId , employee);

export const deleteEmployee =(employeeeId) => axios.delete(EMPLOYEE_API_BASE_URL  + '/' + employeeeId);