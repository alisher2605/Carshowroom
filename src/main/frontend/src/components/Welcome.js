import React from 'react';
import {Jumbotron} from "react-bootstrap";

class Welcome extends React.Component{
    render() {
        return (
            <Jumbotron className="bg-dark text-white">
                <h1>Welcome to the car showroom!</h1>
                <p>
                    Here you purchase or test-drive all cars available!
                </p>
            </Jumbotron>
        );
    }
}

export default Welcome;