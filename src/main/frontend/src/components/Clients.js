import React, {Component} from 'react';
import {Card, Table, Image, ButtonGroup, Button, InputGroup, FormControl} from 'react-bootstrap';
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome';
import {faList, faTrash, faEdit, faShoppingCart} from '@fortawesome/free-solid-svg-icons';
import axios from 'axios';
import {Link} from "react-router-dom";

class Clients extends  Component{
    constructor(props) {
        super(props);
        this.state = {
            clients: []
        };
    }

    componentDidMount() {
        axios.get("http://localhost:8080/api/users")
            .then(response => response.data)
            .then((data) => {
                this.setState(({clients:data}))
            });
    }

    deleteClient = (id) =>{
        axios.delete("http://localhost:8080/api/users/" + id)
            .then(response => {
                if (response.data != null){
                    alert("Deleted!")
                    this.setState({
                        clients: this.state.clients.filter(client => client.clientId !== id)
                    })
                }
            })
    };

    render() {
        return (
            <Card className={"border border-dark bg-dark text-white"}>
                <Card.Header><FontAwesomeIcon icon={faList} /> Clients</Card.Header>
                    <Card.Body>
                        <Table bordered hover striped variant="dark">
                            <thead>
                            <tr>
                                <th>#</th>
                                <th>Username</th>
                                <th>Driving Experience</th>
                                <th>First Name</th>
                                <th>Last Name</th>
                                <th>Gender</th>
                                <th>Membership</th>
                                <th>Actions</th>
                            </tr>
                            </thead>
                            <tbody>
                            {
                                this.state.clients.length === 0 ?
                                    <tr align="center">
                                        <td colSpan="10">{this.state.clients.length}</td>
                                    </tr>:
                                    this.state.clients.map((client) =>(
                                        <tr key={client.clientId}>
                                            <td>{client.clientId}</td>
                                            <td>{client.username}</td>
                                            <td>{client.drivingExperience}</td>
                                            <td>{client.firstName}</td>
                                            <td>{client.lastName}</td>
                                            <td>{client.gender}</td>
                                            <td>{client.hasMembership}</td>
                                            <td>
                                                <ButtonGroup>
                                                    <Link to={"AddClient/" + client.clientId}  className="btn btn-sm btn-outline-primary"><FontAwesomeIcon icon={faEdit} /></Link>{''}
                                                    <Button size="sm" variant="outline-danger" onClick={this.deleteClient.bind(this, client.clientId)}><FontAwesomeIcon icon={faTrash} /></Button>
                                                </ButtonGroup>
                                            </td>
                                        </tr>
                                    ))}

                            </tbody>
                        </Table>
                    </Card.Body>
            </Card>
        )
    }
}

export default Clients;