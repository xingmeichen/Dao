import React from "react";

class Clock extends React.Component {
    
    constructor(props) {
        super(props);
        this.state = {
            date: new Date()
        }
    }

    componentDidMount() {
        this.clock = setInterval(()=>this.tick(), 1000);
    }

    componentWillUnmount() {
        clearInterval(this.clock);
    }

    tick() {
        this.setState({
            date: new Date()
        })
    }

    render() {
        return (
            <div>
                <div>It's {this.state.date.toLocaleTimeString()} now.</div>
            </div>
        );
    }
}

export default Clock;