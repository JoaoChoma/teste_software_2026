import { test, expect } from '@playwright/test';

test.describe('login funcional', () => {
  test('permite login com credenciais válidas', async ({ page }) => {
    await page.goto('/login');

    await page.getByLabel('E-mail').fill('ana@exemplo.com');
    await page.getByLabel('Senha').fill('SenhaSegura123!');
    await page.getByRole('button', { name: 'Entrar' }).click();

    await expect(page).toHaveURL(/\/conta$/);
    await expect(page.getByRole('heading', { name: 'Minha conta' })).toBeVisible();
    await expect(page.getByTestId('usuario')).toHaveText('Usuário: Ana');
    await expect
      .poll(() => page.evaluate(() => sessionStorage.getItem('usuarioAutenticado')))
      .toBe('Ana');
  });

  test('nega login com senha inválida', async ({ page }) => {
    await page.goto('/login');

    await page.getByLabel('E-mail').fill('ana@exemplo.com');
    await page.getByLabel('Senha').fill('senha-incorreta');
    await page.getByRole('button', { name: 'Entrar' }).click();

    await expect(page.getByRole('alert')).toHaveText('E-mail ou senha inválidos');
    await expect(page).toHaveURL(/\/login$/);
    await expect
      .poll(() => page.evaluate(() => sessionStorage.getItem('usuarioAutenticado')))
      .toBeNull();
  });
});

