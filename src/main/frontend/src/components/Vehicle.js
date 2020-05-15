import React, {Component} from 'react';
import {Card, Table, Image, ButtonGroup, Button, InputGroup, FormControl} from 'react-bootstrap';
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome';
import {faList} from '@fortawesome/free-solid-svg-icons';
class Vehicle extends Component{
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
    </tr>
  </thead>
  <tbody>
      <tr align="center">
          <td colSpan="9">No vehicles availble</td>
      </tr>
  </tbody>
                    </Table>
                </Card.Body>
            </Card>
        )
    }
}

export default Vehicle;