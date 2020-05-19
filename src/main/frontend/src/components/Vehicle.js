import React, {Component} from 'react';
import {Card, Table, Image, ButtonGroup, Button, InputGroup, FormControl} from 'react-bootstrap';
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome';
import {faList, faTrash, faEdit} from '@fortawesome/free-solid-svg-icons';
import axios from 'axios';

class Vehicle extends Component{
    constructor(props) {
        super(props);
        this.state = {
            vehicles: []
        };
    }

    componentDidMount() {
        axios.get("http://localhost:8080/api/vehicles")
            .then(response => response.data)
            .then((data) => {
                this.setState(({vehicles:data}))
            });
    }

    deleteVehicle = (id) =>{
        axios.delete("http://localhost:8080/api/vehicles/" + id)
            .then(response => {
                if (response.data != null){
                    alert("Deleted!")
                    this.setState({
                        vehicles: this.state.vehicles.filter(vehicle => vehicle.vehicleId !== id)
                    })
                }
            })
    };

    render() {
        return(
            <Card className={"border border-dark bg-dark text-white"}>
                <Card.Header><FontAwesomeIcon icon={faList} /> Vehicle</Card.Header>

                <Card.Body>
                <Table bordered hover striped variant="dark">
                <thead>
      <tr>
      <th>#</th>
      <th>Model</th>
      <th>Price</th>
      <th>Production Year</th>
      <th>Quantity</th>
      <th>State</th>
      <th>Transmission Type</th>
      <th>Set</th>
      <th>Color</th>
      <th>Action</th>
    </tr>
  </thead>
  <tbody>
  {     this.state.vehicles.length ===0 ?
      <tr align="center">
          <td colSpan="10">{this.state.vehicles.length}</td>
      </tr>:
        this.state.vehicles.map((vehicle) =>(
            <tr key={vehicle.vehicleId}>
                <td>{vehicle.vehicleId}</td>
                <td>{vehicle.model}</td>
                <td>{vehicle.price}</td>
                <td>{vehicle.productionYear}</td>
                <td>{vehicle.quantity}</td>
                <td>{vehicle.state}</td>
                <td>{vehicle.transmissionType}</td>
                <td>{vehicle.vehicleSet}</td>
                <td>{vehicle.color}</td>
                <td>
                 <ButtonGroup>
                     <Button size="sm" variant="outline-primary"><FontAwesomeIcon icon={faEdit} /></Button>{''}
                     <Button size="sm" variant="outline-danger" onClick={this.deleteVehicle.bind(this, vehicle.vehicleId)}><FontAwesomeIcon icon={faTrash} /></Button>
                 </ButtonGroup>
                    </td>
            </tr>
      ))
  }

  </tbody>
                    </Table>
                </Card.Body>
            </Card>
        )
    }
}

export default Vehicle;