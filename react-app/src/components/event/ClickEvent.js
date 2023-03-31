import React from "react";

class ClickEvent extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            isToggleOn: true
        };
    }
    
    handleClick = () => {
        console.log("this: ", this);
        this.setState(state => ({
            isToggleOn: !state.isToggleOn
        }))
    }

    render() {
        return (
            <div>
                <button onClick={this.handleClick} >
                    {this.state.isToggleOn ? 'ON' : 'OFF'}
                </button>
            </div>
        );
    }
}

export default ClickEvent;