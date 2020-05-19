import React, {Component} from 'react';
import {Card,Form, Button, Col} from 'react-bootstrap';
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome';
import {faSave, faUndo} from '@fortawesome/free-solid-svg-icons';
import axios from 'axios';

class AddVehicle extends Component{
    constructor(props){
    super(props);
    this.state = this.initialState;
    this.vehicleChange = this.vehicleChange.bind(this);
    this.submitVehicle = this.submitVehicle.bind(this);
    }

    initialState = {
        model:'', price:'',year:'',quantity:'', state:'',type:'',set:'',color:''
    }

    submitVehicle = event =>{

        event.preventDefault();

        const vehicle = {
            model:  this.state.model,
            price: this.state.price,
            productionYear: this.state.year,
            quantity: this.state.quantity,
            state: this.state.state,
            transmissionType:  this.state.type,
            vehicleSet: this.state.set,
            color: this.state.color
        };
            axios.post("http://localhost:8080/api/vehicles/create", vehicle)
                .then(response => {
                    if (response.data != null){
                        this.setState(this.initialState)
                        alert("Vehicle added successfully")
                    }
                })

    }


    resetVehicle = () => {
        this.setState(() => this.initialState)
    }

    vehicleChange = event =>{
        this.setState({
                [event.target.name]:event.target.value
        });
    }


    render() {
        const {model, price, year, quantity, state, type, set, color} = this.state;
        return(
            <Card className={"border border-dark bg-dark text-white"}>
                <Card.Header>Add Vehicle</Card.Header>
                <Form onReset={this.resetVehicle} onSubmit={this.submitVehicle} id="vehicleFormId">

                <Card.Body>
                <Form.Row     /* Form 1 */>
                <Form.Group as = {Col} controlId="formGridTitle">
                    <Form.Label>Model</Form.Label>
                    <Form.Control 
                    type="text" name="model" 
                    placeholder="Enter Model" required autoComplete="off"
                    className={"bg-dark text-white"}
                    value={model}
                    onChange={this.vehicleChange} 
                    />

                </Form.Group>

                <Form.Group as = {Col} controlId="formGridTitle">
                    <Form.Label>Price</Form.Label>
                    <Form.Control type="text" name="price" placeholder="Enter price" required autoComplete="off"
                       className={"bg-dark text-white"}
                       value={price}
                       onChange={this.vehicleChange} 
                    />
                </Form.Group>
                <Form.Group as = {Col}    controlId="formGridTitle" >
                    <Form.Label>Production Year</Form.Label>
                    <Form.Control type="text" name="year" placeholder="Enter year" required autoComplete="off"
                       className={"bg-dark text-white"}
                       value={year}
                       onChange={this.vehicleChange} 
                    />
                </Form.Group>
                </Form.Row>

                <Form.Row /* Form 2 */>            
                <Form.Group as = {Col} controlId="formGridTitle">
                    <Form.Label>Quantity</Form.Label>
                    <Form.Control type="text" name="quantity" placeholder="Enter quantity" required autoComplete="off"
                       className={"bg-dark text-white"}
                       value={quantity}
                       onChange={this.vehicleChange} 
                    />
                </Form.Group>
                <Form.Group as = {Col} controlId="formGridTitle">
                    <Form.Label>State</Form.Label>
                    <Form.Control type="text" name="state" placeholder="Enter state" required autoComplete="off"
                       className={"bg-dark text-white"}
                       value={state}
                       onChange={this.vehicleChange} 
                    />
                </Form.Group>

                <Form.Group as = {Col} controlId="formGridTitle">
                    <Form.Label>Transmission Type</Form.Label>
                    <Form.Control type="text" name="type" placeholder="Enter yransmission type" required autoComplete="off"
                       className={"bg-dark text-white"}
                       value={type}
                       onChange={this.vehicleChange} 
                    />

                      </Form.Group>
                </Form.Row>

                <Form.Row /* Form 3 */>            
                <Form.Group as = {Col} controlId="formGridTitle">
                    <Form.Label>Set</Form.Label>
                    <Form.Control type="text" name="set" placeholder="Enter set" required autoComplete="off"
                       className={"bg-dark text-white"}
                       value={set}
                       onChange={this.vehicleChange} 
                    />
                </Form.Group>
                <Form.Group as = {Col} controlId="formGridTitle">
                    <Form.Label>Color</Form.Label>
                    <Form.Control type="text" name="color" placeholder="Enter color" required autoComplete="off"
                       className={"bg-dark text-white"}
                       value={color}
                       onChange={this.vehicleChange} 
                    />
                </Form.Group>
                </Form.Row>


                </Card.Body>
                <Card.Footer style={{"textAlign":"right"}}>
                <Button size="sm" variant="success" type="submit">
               < FontAwesomeIcon icon={faSave}/> Submit
                </Button>{' '}
                    <Button size="sm" variant="info" type="reset">
                        < FontAwesomeIcon icon={faUndo}/> Reset
                    </Button>
                </Card.Footer>
                </Form>
            </Card>
            
            )
    }
}

export default AddVehicle;