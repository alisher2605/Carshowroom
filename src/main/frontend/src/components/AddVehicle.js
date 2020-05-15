import React, {Component} from 'react';
import {Card,Form, Button, Col} from 'react-bootstrap';
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome';
import {faSave} from '@fortawesome/free-solid-svg-icons';

class AddVehicle extends Component{
    constructor(props){
    super(props);
    this.state = {model:'', price:'',year:'',quantity:'', state:'',type:'',set:'',color:''};
    this.vehicleChange = this.vehicleChange.bind(this);
    this.submitVehicle = this.submitVehicle.bind(this);
    }

    submitVehicle(event){
        alert('Model: ' + this.state.model + ', Price: ' + this.state.price
        + ', Production year: ' + this.state.year + ', Quantity: ' + this.state.quantity
        + ', State: ' + this.state.state + ', Type: ' + this.state.type +
        ', Set: ' + this.state.set + ', Color: ' + this.state.color
        );
        event.preventDefault();
    }

    vehicleChange(event){
        this.setState({
                [event.target.name]:event.target.value
        });
    }

    render() {
        return(
            <Card className={"border border-dark bg-dark text-white"}>
                <Card.Header>Add Vehicle</Card.Header>
                <Form onSubmit={this.submitVehicle} id="vehicleFormId">

                <Card.Body>
                <Form.Row     /* Form 1 */>
                <Form.Group as = {Col} controlId="formGridTitle">
                    <Form.Label>Model</Form.Label>
                    <Form.Control 
                    type="text" name="model" 
                    placeholder="Enter Model" required
                    className={"bg-dark text-white"}
                    value={this.state.model}
                    onChange={this.vehicleChange} 
                    />

                </Form.Group>

                <Form.Group as = {Col} controlId="formGridTitle">
                    <Form.Label>Price</Form.Label>
                    <Form.Control type="text" name="price" placeholder="Enter price" required
                       className={"bg-dark text-white"}
                       value={this.state.price}
                       onChange={this.vehicleChange} 
                    />
                </Form.Group>
                <Form.Group as = {Col}    controlId="formGridTitle" >
                    <Form.Label>Production Year</Form.Label>
                    <Form.Control type="text" name="year" placeholder="Enter year" required
                       className={"bg-dark text-white"}
                       value={this.state.year}
                       onChange={this.vehicleChange} 
                    />
                </Form.Group>
                </Form.Row>

                <Form.Row /* Form 2 */>            
                <Form.Group as = {Col} controlId="formGridTitle">
                    <Form.Label>Quantity</Form.Label>
                    <Form.Control type="text" name="quantity" placeholder="Enter quantity" required
                       className={"bg-dark text-white"}
                       value={this.state.quantity}
                       onChange={this.vehicleChange} 
                    />
                </Form.Group>
                <Form.Group as = {Col} controlId="formGridTitle">
                    <Form.Label>State</Form.Label>
                    <Form.Control type="text" name="state" placeholder="Enter state" required
                       className={"bg-dark text-white"}
                       value={this.state.state}
                       onChange={this.vehicleChange} 
                    />
                </Form.Group>

                <Form.Group as = {Col} controlId="formGridTitle">
                    <Form.Label>Transmission Type</Form.Label>
                    <Form.Control type="text" name="type" placeholder="Enter yransmission type" required
                       className={"bg-dark text-white"}
                       value={this.state.type}
                       onChange={this.vehicleChange} 
                    />

                      </Form.Group>
                </Form.Row>

                <Form.Row /* Form 3 */>            
                <Form.Group as = {Col} controlId="formGridTitle">
                    <Form.Label>Set</Form.Label>
                    <Form.Control type="text" name="set" placeholder="Enter set" required
                       className={"bg-dark text-white"}
                       value={this.state.set}
                       onChange={this.vehicleChange} 
                    />
                </Form.Group>
                <Form.Group as = {Col} controlId="formGridTitle">
                    <Form.Label>Color</Form.Label>
                    <Form.Control type="text" name="color" placeholder="Enter color" required
                       className={"bg-dark text-white"}
                       value={this.state.color}
                       onChange={this.vehicleChange} 
                    />
                </Form.Group>
                </Form.Row>


                </Card.Body>
                <Card.Footer style={{"textAlign":"right"}}>
                <Button size="sm" variant="success" type="submit">
               < FontAwesomeIcon icon={faSave}/> Submit
                </Button>
                </Card.Footer>
                </Form>
            </Card>
            
            )
    }
}

export default AddVehicle;