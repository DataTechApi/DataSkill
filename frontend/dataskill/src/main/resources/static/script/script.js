const toggle = document.getElementById('toggleMode');
    const body = document.body;


    function applyTheme(theme) {
      if (theme === 'light') {
        body.classList.remove('dark-mode');
        body.classList.add('light-mode');
        toggle.checked = true;
      } else {
        body.classList.remove('light-mode');
        body.classList.add('dark-mode');
        toggle.checked = false;
      }
    }


    const savedTheme = localStorage.getItem('theme') || 'dark';
    applyTheme(savedTheme);


    toggle.addEventListener('change', () => {
      const newTheme = toggle.checked ? 'light' : 'dark';
      localStorage.setItem('theme', newTheme);
      applyTheme(newTheme);
    });