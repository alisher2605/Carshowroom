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
                <Link to={"/"} className="navbar-brand">Home</Link>
                <Link to={"manufacturers"} className="navbar-brand">Manufacturers</Link>
                <Link to={"cars"} className="navbar-brand">Cars</Link>
                <Link to={"clients"} className="navbar-brand">Clients</Link>
            </Nav>
        </Navbar>
    );
}