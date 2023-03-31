import React from "react";

class ClickEventB extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            isToggleOn: true
        };

        // 为了在回调中使用 `this`, 这个绑定是必不可少的
        this.handleClick = this.handleClick.bind(this);
    }
    
    handleClick() {
        console.log("this: ", this);
        this.setState(state => ({
            isToggleOn: !state.isToggleOn
        }))
    }

    render() {
        return (
            <div>
                {/* 这里的调用没有带(), 就是因为在构造函数中已经绑定过了，如果没有绑定过，则必须带有() */}
                <button onClick={this.handleClick} >
                    {this.state.isToggleOn ? 'ON' : 'OFF'}
                </button>
            </div>
        );
    }
}

export default ClickEventB;