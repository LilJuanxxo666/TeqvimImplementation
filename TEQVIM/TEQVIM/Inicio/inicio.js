const username = document.getElmentById('username')
const password= document.getElmentById('password')
const button = document.getElmentById('button')

button.addEventListener('click', (e) => {
    e.preventDefault()
    const data = {
        username: username.value,
        password: password.value
    }
})
