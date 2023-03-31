
const NumberList = (props) => {
    return (
        <ul>
            {
                props.numbers.map((number) => {
                    return <li key={number} value={number * 2}>{number}</li>
                })
            }
        </ul>
    );
}

export default NumberList;