import React, {Component} from "react";
import {Card,Form, Button, Col} from 'react-bootstrap';

class Login extends  Component{
    constructor() {
        super();
        this.state = {
            nickname:null,
            password:null,
            login:false,
            store: null
        }
    }


        render() {
            return(
                <Form>
                    <Form.Group as = {Col} controlId="formGridTitle" >
                        <Form.Label
                            className={"border border-dark bg-dark text-white"}>
                            Name
                        </Form.Label>
                        <Form.Control type="text" placeholder="Enter name"
                                      className={"bg-dark text-white"}
                                      onChange={(event)=>{this.setState({nickname:event.target.value})}}
                                      required
                        />
                    </Form.Group>
                    <Form.Group as = {Col} controlId="formGridTitle">
                        <Form.Label
                            className={"border border-dark bg-dark text-white"}>Password</Form.Label>
                        <Form.Control type="password" placeholder="Password"
                                      className={"bg-dark text-white"}
                                      onChange={(event)=>{this.setState({password:event.target.value})}}
                                      required
                        />
                    </Form.Group>
                    <Button variant="primary" type="submit" size="sm" onClick={()=>{}}>
                           Submit
                    </Button>
                </Form>
            )
        }
}

export default Login;