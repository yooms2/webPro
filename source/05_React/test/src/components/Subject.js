import './Subject.css';
const Subject = props => {
    // props.title = '수정불가. ReadOnly'; => 변경시 state화
    return (
        <header className="Subject">
            <h1 onClick={() => {
                props.onChangeMode();
            }}>
                {props.title}
            </h1>
            {props.sub}
        </header>
    );
};
export default Subject;