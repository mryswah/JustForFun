/*!
 * Start Bootstrap - SB Admin v7.0.7 (https://startbootstrap.com/template/sb-admin)
 * Copyright 2013-2023 Start Bootstrap
 * Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-sb-admin/blob/master/LICENSE)
 */
//
// Scripts
//

window.addEventListener('DOMContentLoaded', event => {
    // Toggle the side navigation
    const sidebarToggle = document.body.querySelector('#sidebarToggle');
    if (sidebarToggle) {
        // Uncomment Below to persist sidebar toggle between refreshes
        // if (localStorage.getItem('sb|sidebar-toggle') === 'true') {
        //     document.body.classList.toggle('sb-sidenav-toggled');
        // }
        sidebarToggle.addEventListener('click', event => {
            event.preventDefault();
            document.body.classList.toggle('sb-sidenav-toggled');
            localStorage.setItem('sb|sidebar-toggle', document.body.classList.contains('sb-sidenav-toggled'));
        });
    }

    // For Login Page
    const usernameInput = document.getElementById("username");
    const passwordInput = document.getElementById("password");
    const loginButton = document.getElementById("login-button");
    if (usernameInput != null && passwordInput != null && loginButton != null) {
        loginButton.style.cursor = "default";
        usernameInput.addEventListener("input", () => {
            if (usernameInput.value && passwordInput.value) {
                loginButton.removeAttribute("disabled");
                loginButton.style.cursor = "pointer";
            } else {
                loginButton.setAttribute("disabled", "");
                loginButton.style.cursor = "default";
            }
        });
        passwordInput.addEventListener("input", () => {
            if (usernameInput.value && passwordInput.value) {
                loginButton.removeAttribute("disabled");
                loginButton.style.cursor = "pointer";
            } else {
                loginButton.setAttribute("disabled", "");
                loginButton.style.cursor = "default";
            }
        });
    }

    // For Login Popup Page
    const popupUsernameInput = document.getElementById("popupusername");
    const popupPasswordInput = document.getElementById("popuppassword");
    const popupLoginButton = document.getElementById("popup-login-button");
    if (popupUsernameInput != null && popupPasswordInput != null && popupLoginButton != null) {
        popupLoginButton.style.cursor = "default";
        popupUsernameInput.addEventListener("input", () => {
            if (popupUsernameInput.value && popupPasswordInput.value) {
                popupLoginButton.removeAttribute("disabled");
                popupLoginButton.style.cursor = "pointer";
            } else {
                popupLoginButton.setAttribute("disabled", "");
                popupLoginButton.style.cursor = "default";
            }
        });
        popupPasswordInput.addEventListener("input", () => {
            if (popupUsernameInput.value && popupPasswordInput.value) {
                popupLoginButton.removeAttribute("disabled");
                popupLoginButton.style.cursor = "pointer";
            } else {
                popupLoginButton.setAttribute("disabled", "");
                popupLoginButton.style.cursor = "default";
            }
        });
    }

    // For Registration Page
    const nameRegInput = document.getElementById("regname");
    const emailRegInput = document.getElementById("regemail");
    const usernameRegInput = document.getElementById("regusername");
    const passwordRegInput = document.getElementById("regpassword");
    const registerButton = document.getElementById("register-button");
    if (nameRegInput != null && emailRegInput != null && usernameRegInput != null && passwordRegInput != null && registerButton != null) {
        registerButton.style.cursor = "default";
        nameRegInput.addEventListener("input", () => {
            if (nameRegInput.value && emailRegInput.value && usernameRegInput.value && passwordRegInput.value) {
                registerButton.removeAttribute("disabled");
                registerButton.style.cursor = "pointer";
            } else {
                registerButton.setAttribute("disabled", "");
                registerButton.style.cursor = "default";
            }
        });
        emailRegInput.addEventListener("input", () => {
            if (nameRegInput.value && emailRegInput.value && usernameRegInput.value && passwordRegInput.value) {
                registerButton.removeAttribute("disabled");
                registerButton.style.cursor = "pointer";
            } else {
                registerButton.setAttribute("disabled", "");
                registerButton.style.cursor = "default";
            }
        });
        usernameRegInput.addEventListener("input", () => {
            if (nameRegInput.value && emailRegInput.value && usernameRegInput.value && passwordRegInput.value) {
                registerButton.removeAttribute("disabled");
                registerButton.style.cursor = "pointer";
            } else {
                registerButton.setAttribute("disabled", "");
                registerButton.style.cursor = "default";
            }
        });
        passwordRegInput.addEventListener("input", () => {
            if (nameRegInput.value && emailRegInput.value && usernameRegInput.value && passwordRegInput.value) {
                registerButton.removeAttribute("disabled");
                registerButton.style.cursor = "pointer";
            } else {
                registerButton.setAttribute("disabled", "");
                registerButton.style.cursor = "default";
            }
        });
    }

    // For Registration Popup Page
    const popupNameRegInput = document.getElementById("popupregname");
    const popupEmailRegInput = document.getElementById("popupregemail");
    const popupUsernameRegInput = document.getElementById("popupregusername");
    const popupPasswordRegInput = document.getElementById("popupregpassword");
    const popupRegisterButton = document.getElementById("popup-register-button");
    if (popupNameRegInput != null && popupEmailRegInput != null && popupUsernameRegInput != null && popupPasswordRegInput != null && popupRegisterButton != null) {
        popupRegisterButton.style.cursor = "default";
        popupNameRegInput.addEventListener("input", () => {
            if (popupNameRegInput.value && popupEmailRegInput.value && popupUsernameRegInput.value && popupPasswordRegInput.value) {
                popupRegisterButton.removeAttribute("disabled");
                popupRegisterButton.style.cursor = "pointer";
            } else {
                popupRegisterButton.setAttribute("disabled", "");
                popupRegisterButton.style.cursor = "default";
            }
        });
        popupEmailRegInput.addEventListener("input", () => {
            if (popupNameRegInput.value && popupEmailRegInput.value && popupUsernameRegInput.value && popupPasswordRegInput.value) {
                popupRegisterButton.removeAttribute("disabled");
                popupRegisterButton.style.cursor = "pointer";
            } else {
                popupRegisterButton.setAttribute("disabled", "");
                popupRegisterButton.style.cursor = "default";
            }
        });
        popupUsernameRegInput.addEventListener("input", () => {
            if (popupNameRegInput.value && popupEmailRegInput.value && popupUsernameRegInput.value && popupPasswordRegInput.value) {
                popupRegisterButton.removeAttribute("disabled");
                popupRegisterButton.style.cursor = "pointer";
            } else {
                popupRegisterButton.setAttribute("disabled", "");
                popupRegisterButton.style.cursor = "default";
            }
        });
        popupPasswordRegInput.addEventListener("input", () => {
            if (popupNameRegInput.value && popupEmailRegInput.value && popupUsernameRegInput.value && popupPasswordRegInput.value) {
                popupRegisterButton.removeAttribute("disabled");
                popupRegisterButton.style.cursor = "pointer";
            } else {
                popupRegisterButton.setAttribute("disabled", "");
                popupRegisterButton.style.cursor = "default";
            }
        });
    }
});

window.addEventListener('load', function() {
    var loginSuccess = document.querySelector('.popup-login-success');
    if (loginSuccess != null) {
        setTimeout(
            function open(event) {
                document.querySelector('.popup-login-success').style.display = 'block';
            }, 0
        );
        document.querySelector('.popup-login-success').addEventListener("click", function() {
            document.querySelector('.popup-login-success').style.display = 'none';
        });
        setTimeout(
            function close(event) {
                document.querySelector('.popup-login-success').style.display = 'none';
            }, 5000
        );
    }
    var logoutSuccess = document.querySelector('.popup-logout-success');
    if (logoutSuccess != null) {
        setTimeout(
            function open(event) {
                document.querySelector('.popup-logout-success').style.display = 'block';
            }, 0
        );
        document.querySelector('.popup-logout-success').addEventListener("click", function() {
            document.querySelector('.popup-logout-success').style.display = 'none';
        });
        setTimeout(
            function close(event) {
                document.querySelector('.popup-logout-success').style.display = 'none';
            }, 5000
        );
    }
});

// Meme image uploading --- START
$(document).ready(function() {
    $('.upload-container').add('.upload-btn').click(function() {
        $('#upload-input').trigger('click');
    });
    $('#upload-input').change(event => {
        const file = event.target.files[0];
        const reader = new FileReader();
        if (file != null && file.type.match(/^image\/(png|jpeg|jpg|gif)$/)) {
            reader.readAsDataURL(file);
            reader.onloadend = () => {
                $('.upload-img img').attr('aria-label', file.name);
                $('.upload-img img').attr('src', reader.result);
            }
        } else {
            // Revert back to original image on the Upload Meme Page
            $('.upload-img img').attr('src', 'https://cdn-icons-png.flaticon.com/512/9052/9052945.png');
            $('.upload-img img').attr('aria-label', 'No image selected');
        }
    });
});

// Pop up box for Login/Registration at main page --- START
var loginBtn = document.getElementById('login-btn');
if (loginBtn != null) {
    document.getElementById('login-btn').addEventListener('click', function(e) {
        e.preventDefault();
        document.getElementById('login-popup').style.display = 'block';
        document.getElementById('register-popup').style.display = 'none';
    });
}
var loginBtnExisting = document.getElementById('login-btn-existing');
if (loginBtnExisting != null) {
    document.getElementById('login-btn-existing').addEventListener('click', function(e) {
        e.preventDefault();
        document.getElementById('login-popup').style.display = 'block';
        document.getElementById('register-popup').style.display = 'none';
    });
}
// Close the pop-up box when clicking outside of it
document.addEventListener('click', function(e) {
    if (e.target.id === 'login-popup') {
        document.getElementById('login-popup').style.display = 'none';
    }
});
var registerBtn = document.getElementById('register-btn');
if (registerBtn != null) {
    document.getElementById('register-btn').addEventListener('click', function(e) {
        e.preventDefault();
        document.getElementById('login-popup').style.display = 'none';
        document.getElementById('register-popup').style.display = 'block';
    });
}
// Close the pop-up box when clicking outside of it
document.addEventListener('click', function(e) {
    if (e.target.id === 'register-popup') {
        document.getElementById('register-popup').style.display = 'none';
    }
});

// Pop up box when user's clicks "Post" before they logged into their account
// User can only post memes once they've logged in, this pop up is to prompt user to log in --- START
var memesUploadLoginBtn = document.getElementById('memes-upload-login-btn');
if (memesUploadLoginBtn != null) {
    document.getElementById('memes-upload-login-btn').addEventListener('click', function(e) {
        e.preventDefault();
        document.getElementById('login-popup').style.display = 'block';
        document.getElementById('register-popup').style.display = 'none';
    });
}

// Pop up box when User wishes to delete their own account --- START
var deleteBtn = document.getElementById('delete-btn');
if (deleteBtn != null) {
    document.getElementById('delete-btn').addEventListener('click', function(e) {
        e.preventDefault();
        document.getElementById('delete-popup').style.display = 'block';
    });
}
document.addEventListener('click', function(e) {
    if (e.target.id === 'delete-popup') {
        document.getElementById('delete-popup').style.display = 'none';
    }
});

// Pop up box when User's deleting a Post --- START
document.addEventListener('click', function(e) {
    const deletePostPopups = document.querySelectorAll("[id*='delete-post-popup_']");
    if (deletePostPopups != null) {
        deletePostPopups.forEach(function(popup) {
            if (e.composedPath().includes(popup)) {
                console.log("In the close");
                deletePostPopups.forEach(function(popup) {
                    popup.style.display = 'none';
                });
            }
        });
    }
});
var deleteBtn = document.querySelectorAll("[id^='delete-post-btn_']");
var deletePostPopup = document.querySelectorAll("[id^='delete-post-popup_']");
// Loop over each post button
for (var i = 0; i < deleteBtn.length + 1; i++) {
    // Create a new scope for each iteration of the loop
    (function(index) {
        if (deleteBtn[index] != null) {
            deleteBtn[index].addEventListener("click", function() {
                // Loop over each post popup
                for (var j = 0; j < deletePostPopup.length; j++) {
                    // Extract the index from the popup's ID
                    var popupIndex = parseInt(deletePostPopup[j].id.split("_")[1]);

                    // If the popup's index matches the button's index, show the popup
                    if (popupIndex === index) {
                        deletePostPopup[j].style.display = "block";
                    }
                }
            });
        }
    })(i); // Pass the current index to the IIFE
}