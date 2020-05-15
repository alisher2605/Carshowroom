import React from 'react';

import {Navbar, Nav} from 'react-bootstrap';
import {Link} from "react-router-dom";

export default function NavigationBar() {
    return (
        <Navbar bg="dark" variant="dark">
            <Link to ={""} className="navbar-brand" >
                <img src="https://image.flaticon.com/icons/svg/26/26246.svg" width="50" height="40" alt="brand"/> Car showroom

            </Link>

            <Nav className="mr-auto">
            <Link to={"Vehicle"}  className="navbar-brand">Vehicle</Link>
            <Link to={"AddVehicle"}  className="navbar-brand">Add vehicle</Link>
            <Link to={"Manufacturer"}  className="navbar-brand">Manufacturers</Link>
            </Nav>
        </Navbar>
    );
}