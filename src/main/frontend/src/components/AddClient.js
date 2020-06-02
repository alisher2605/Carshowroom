import React, {Component} from 'react';
import {Card,Form, Button, Col} from 'react-bootstrap';
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome';
import {faSave, faUndo, faList} from '@fortawesome/free-solid-svg-icons';
import axios from 'axios';

class AddClient extends Component{
    constructor(props){
        super(props);
        this.state = this.initialState;
        this.userChange = this.userChange.bind(this);
        this.submitClient= this.submitClient.bind(this);
    }

    initialState = {
        experience:'' ,username:'', firstName:'',lastName:'', gender:''
    };

    submitClient = event =>{
        event.preventDefault();
        const vehicle = {
            experience: this.state.experience,
            username: this.state.username,
            firstName: this.state.firstName,
            lastName: this.state.lastName,
            gender: this.state.gender
        };
        axios.post("http://localhost:8080/api/users/create", vehicle)
            .then(response => {
                if (response.data != null){
                    this.setState(this.initialState)
                    alert("Client added successfully")
                }
            })

    };

    userChange  = event =>{
        this.setState({
            [event.target.name]:event.target.value
        });
    };


    userList = () =>{
        return this.props.history.push("/Clients")
    };
    render() {
        const {username,experience,firstName,lastName, gender} = this.state
        return(
            <Card className={"border border-dark bg-dark text-white"}>
                <Card.Header>{"Add Client"}</Card.Header>
                {/*onReset={this.resetUser} onSubmit={this.submitUser}*/}
                <Form onSubmit={this.submitClient} id="clientFormId">
                    <Card.Body>
                        <Form.Row     /* Form 1 */>
                            <Form.Group as = {Col} controlId="formGridTitle">
                                <Form.Label>Username</Form.Label>
                                <Form.Control
                                    type="text" name="username"

                                    placeholder="Username" required autoComplete="off"
                                    className={"bg-dark text-white"}
                                    onChange={this.vehicleChange}
                                />
                            </Form.Group>

                            <Form.Group as = {Col} controlId="formGridTitle">
                                <Form.Label>Experience</Form.Label>
                                <Form.Control type="text" name="experience" placeholder="Enter driving experience" required autoComplete="off"
                                              className={"bg-dark text-white"}
                                              onChange={this.vehicleChange}
                                />
                            </Form.Group>
                            <Form.Group as = {Col}    controlId="formGridTitle" >
                                <Form.Label>First name</Form.Label>
                                <Form.Control type="text" name="name" placeholder="Enter name" required autoComplete="off"
                                              className={"bg-dark text-white"}

                                              onChange={this.vehicleChange}
                                />
                            </Form.Group>
                        </Form.Row>

                        <Form.Row /* Form 2 */>
                            <Form.Group as = {Col} controlId="formGridTitle">
                                <Form.Label>Last Name</Form.Label>
                                <Form.Control type="text" name="surname" placeholder="Enter surname" required autoComplete="off"
                                              className={"bg-dark text-white"}
                                              onChange={this.vehicleChange}
                                />
                            </Form.Group>


                        </Form.Row>

                    </Card.Body>

                    <Card.Footer style={{"textAlign":"right"}}>
                        <Button size="sm" variant="success" type="submit">
                            < FontAwesomeIcon icon={faSave}/> {"Save"}
                        </Button>{' '}

                        <Button size="sm" variant="info" type="reset">
                            < FontAwesomeIcon icon={faUndo}/> Reset
                        </Button>{' '}
                        <Button size="sm" variant="info" type="button" onClick={this.userList.bind()}>
                            < FontAwesomeIcon icon={faList}/> Clients list
                        </Button>
                    </Card.Footer>
                </Form>
            </Card>
        )
    }
}

export default AddClient