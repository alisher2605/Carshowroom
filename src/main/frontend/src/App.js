import React from 'react';
import './App.css';
import NavigationBar from "./components/NavigationBar";
import Welcome  from "./components/Welcome";

import {Container, Row,Col} from 'react-bootstrap';
import {BrowserRouter as Router, Switch, Route} from 'react-router-dom';
import Vehicle from "./components/Vehicle";
import AddVehicle from "./components/AddVehicle";
import Login from "./components/Login"
import Clients from "./components/Clients"
import AddClient from "./components/AddClient";
function App() {
    const  marginTop = {
         marginTop:"20px"
    }

  return (
    <Router>
        <NavigationBar/>
        <Container>
            <Row>
               {/* <Col lg = {12} className=>"text-center text-muted>*/}
                <Col lg = {12} style={marginTop}>
                    <Switch>
                        <Route path="/" exact component={Welcome}/>
                        <Route path="/AddVehicle/:id" exact component={AddVehicle}/>
                        <Route path="/vehicle" exact component={Vehicle}/>
                        <Route path="/addvehicle" exact component={AddVehicle}/>
                        <Route path="/login" exact component={Login}/>
                        <Route path="/clients" exact component={Clients}/>
                        <Route path="/addclient" exact component={AddClient}/>
                    </Switch>
                </Col>
            </Row>
        </Container>
    </Router>
  );
}

export default App;
