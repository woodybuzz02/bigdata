import React from 'react'
import Button from '../../Commons/Button'
import Input from '../../Commons/Input'
import classes from './AddBookForm.module.css'

const AddBookForm = () => {
  return (
    <form className={classes.form}>
        <Input label={'Amount'} 
               input={{
                   id: 'amount',
                   type: 'number',
                   defaultValue: '1',
               }}
        />
        <Button type="submit">Add</Button>
    </form>
  )
}

export default AddBookForm