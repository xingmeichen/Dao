import { useState } from "react";

const AddList = (props) => {

    const [value, resetValue] = useState('');

    const changeValue = (newValue) => {
        resetValue(newValue);
    }

    return (
        <div>
            <input value={value} placeholder="Enter here" onChange={(e) => changeValue(e.target.value)} />
            <button onClick={() => {
                props.addItem(value);
                resetValue('');
            }}>Add</button>
        </div>
    );
}

export default AddList;